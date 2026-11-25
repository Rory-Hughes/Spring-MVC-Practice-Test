# Answer key

Open these after completing the [practice exam](../Practice%20Exam.md). The files are organized in the same paths as the starter so you can compare them side by side.

- [EquipmentController.java](src/main/java/ITSD/Controller/EquipmentController.java) has the list, edit and update handlers.
- [EquipmentEditForm.java](src/main/java/ITSD/Model/EquipmentEditForm.java) has the validation rules.
- [EquipmentService.java](src/main/java/ITSD/Service/EquipmentService.java) has the repository calls and update.
- [list.html](src/main/resources/templates/equipment/list.html) renders the collection and Edit links.
- [edit.html](src/main/resources/templates/equipment/edit.html) shows form binding and field errors. Read it as source code in your editor to see the Thymeleaf attributes.

To run the answer key, stop any other copy of the practice app, then open PowerShell in the practice-test folder and create a fresh copy of the starter source. Choose a new folder name if `completed-review` already exists.

```powershell
New-Item -ItemType Directory -Path .\completed-review
Copy-Item -LiteralPath .\starter\src, .\starter\.mvn, .\starter\pom.xml, .\starter\mvnw.cmd -Destination .\completed-review -Recurse
Copy-Item -LiteralPath .\answer-key\src -Destination .\completed-review -Recurse -Force
Set-Location .\completed-review
.\mvnw.cmd spring-boot:run
```

Open http://localhost:8085/equipment after the application starts.
