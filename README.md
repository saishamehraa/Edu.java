# Edu.java

Edu.java is a Java NetBeans project for a small educational/course management application created from Udemy course material. It contains NetBeans GUI forms, server/client helpers, and database loader utilities to manage courses, categories, lectures and users.

**Admin Side Features:**
- Admin login and authentication UI
- Add / edit / delete categories
- Add / edit / delete courses
- Add / edit / delete lectures
- Manage users and reset passwords
- View and manage uploaded content
- Server control UI (`server_on_off`) and email/OTP utilities

**User Side Features:**
- User signup and login UI
- Browse categories and courses
- View lecture details and content
- Edit profile, change password
- Email/OTP based verification utilities

**Key Files / Structure:**
- `build.xml`, `nbproject/` — NetBeans project and Ant build files
- `src/` — source files and NetBeans form files
- Notable classes: `myServer.java`, `myClient.java`, `DBLoader.java`, `home.java`, `admin_home.java`, `user_home.java`

**Requirements**
- Java JDK 8 or newer
- Apache Ant (for command-line builds)
- NetBeans IDE (recommended for working with `.form` files)

**Setup & Run**

- Using NetBeans (recommended):
  1. Open NetBeans -> `File` -> `Open Project` -> select this repository root (where `build.xml` exists).
  2. Let NetBeans configure the project and run using the Run button.

- Using PowerShell / Command line (Windows):
  - Build with Ant:

```powershell
ant -f build.xml
```

  - Run with Ant (if a `run` target exists):

```powershell
ant -f build.xml run
```

  - Manual compile example (adjust namespaces / paths as required):

```powershell
# compile all java files into 'out' directory
javac -d out -sourcepath src (Get-ChildItem -Recurse -Filter "*.java" -Path src | ForEach-Object FullName)
# run an entry point, e.g. server or client (adjust package/class name)
java -cp out mycodes.myServer
```

**Notes**
- Many UI files are NetBeans `.form` files — edit them inside NetBeans to avoid corrupting layout metadata.
- Check `DBLoader.java` and any configuration files for database connection settings before running features that access a database.

**Contributing**
- Open an issue or PR with clear description and steps to reproduce.

**License**
- This project is provided under the MIT License — see the `LICENSE` file.
