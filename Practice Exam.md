# Spring MVC practice exam | Trail equipment

**Suggested time** 60 minutes plus 10 minutes to check your work. This is a mock exam based on the announcement. The timing, scenario and marks are practice choices.

A trail crew needs a page to view its equipment inventory and correct the name and quantity on existing records. You have a Spring Boot project with the entity, repository, seed data, and partial controller, service, edit form model and templates.

## Setup

1. Open `starter` as a Maven project in IntelliJ. Use JDK 17 or newer. You can also open a PowerShell terminal in `starter` and run:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

2. Go to [localhost:8085/equipment](http://localhost:8085/equipment). The starter should show the heading and column labels with no rows. Use Ctrl+C to stop the application, and restart it after edits to pick up changes.
3. The first run can download Maven and dependencies. The embedded H2 database loads three rows at startup. Data survives page reloads while the app runs. Stopping the app resets the database, so verify persistence before stopping it.

The files to complete are under `starter/src/main`. Find the Java files under `java/ITSD` and the templates under `resources/templates/equipment`.

## 1. GET and POST handlers using Model | 25 marks

Work in `EquipmentController.java`.

| Method and URL | Expected result |
| --- | --- |
| GET `/equipment` | Add the sorted collection to the model as `equipmentList`. Render `equipment/list`. |
| GET `/equipment/{id}/edit` | Load the record by URL ID. Add it as `equipmentRecord`. Copy its current name and quantity into an `EquipmentEditForm`, add it as `equipmentForm` and render `equipment/edit`. |
| POST `/equipment/{id}/edit` | Bind and validate the submitted `equipmentForm`. If it has errors, put `equipmentRecord` back in the model and return `equipment/edit` with the submitted values and errors. Otherwise call the service to update the row, then redirect to `/equipment`. |

An unknown numeric ID should result in HTTP 404 on both edit routes. The templates use the record for its ID and asset tag. On a POST with errors, keep the bound form available for Thymeleaf.

## 2. Validation and error messages | 25 marks

Work in `EquipmentEditForm.java`, `EquipmentController.java` and `edit.html`.

- **Name** is required, cannot be whitespace only and has a maximum of 60 characters.
- **Quantity** is required and must be a whole number from 0 to 100 inclusive. The form already uses `Integer` so a blank quantity can reach validation as null.
- Add Jakarta validation annotations with clear messages. Use `@Valid` on the bound form and inspect its `BindingResult` before saving.
- Show field errors beside each input using Thymeleaf error attributes. Visually mark invalid inputs. The starter has an `invalid` CSS class.
- Leave the form's `novalidate` attribute in place so the exercise checks server-side validation.

## 3. Collection table | 15 marks

Work in `list.html`. Use a row loop to show the asset tag, name, quantity and an Edit link for every record. Each link should include that record's ID and open its own edit form. The expected asset-tag order is TR-103, TR-202, TR-305.

## 4. Edit form | 15 marks

Work in `edit.html`. Show the asset tag as read-only text. Bind the name and quantity inputs to the form object so they show the current values when the page opens. Post to the edit URL for the selected ID. Keep the starter's Save and Cancel controls.

## 5. Database reads and update | 20 marks

Work in `EquipmentService.java`. Use the provided repository to list records by asset tag and find a record by ID. For the update, load the existing record, copy over its name and quantity, save it and report success. Report failure when the ID is missing. The record keeps its original ID and asset tag, and the row count stays at three.

## Mark your attempt

| Marks | What to verify |
| --- | --- |
| 10 | The list GET passes the collection and the edit GET loads the selected row and prefilled form. |
| 15 | A valid POST redirects, an invalid POST re-renders the form with its supporting model data, and an unknown numeric ID returns 404. |
| 15 | Each validation rule works and invalid submissions skip the update. |
| 10 | Errors appear beside the right inputs and those inputs are highlighted. |
| 15 | The table displays three correctly ordered records with working row-specific links. |
| 15 | The edit form shows the asset tag and prefilled inputs and posts to the selected ID. |
| 20 | The service reads the correct records and persists edits to exactly the selected row while preserving its ID and tag. |

### Browser checks

1. Open Edit on **TR-103**. Confirm you see **Trail radio** and **4**.
2. Clear both fields and save. Look for both errors, the same asset tag, and the same edit URL. Open the list in another tab to verify the stored name and quantity are still unchanged.
3. Enter a name with 61 characters and a quantity of **101**. Save and check both errors. Also try a whitespace-only name and a quantity of **-1**. Try **3.5** as well and look for the whole-number error.
4. Use **Weather radio** and **0**. Save and verify you land back on the list. Refresh and reopen its Edit link. Confirm the new values, the same tag, and three rows. Repeat with **100** to check the upper boundary.
5. Open `/equipment/999/edit` and check for a 404. A direct POST to that URL with valid values should also return 404. To check the latter in PowerShell 7, run:

   ```powershell
   $response = Invoke-WebRequest -Uri 'http://localhost:8085/equipment/999/edit' `
       -Method Post -Body @{ name = 'Weather radio'; quantity = '8' } -SkipHttpErrorCheck
   $response.StatusCode
   ```

6. Compare with the separate [Answer Key](answer-key/README.md) once you have scored your attempt.
