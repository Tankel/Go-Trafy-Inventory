# Go-Trafy-Inventory
Go-Trafy-Inventory is an inventory management system app created for a local convenience store named "GO Trafy". The project is built using Java Swing for the user interface and MySQL for the database.

## Database credentials
Database credentials are no longer hardcoded in source files.

Use environment variables (or Java system properties) before running the app:

- `DB_URL` (default: `jdbc:mysql://localhost:3306/trafy_inventory`)
- `DB_USER` (default: `root`)
- `DB_PASSWORD` (required if your MySQL user has a password)

PowerShell example:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/trafy_inventory"
$env:DB_USER="root"
$env:DB_PASSWORD="your_password_here"
```

You can also use:

```powershell
java -Ddb.url="jdbc:mysql://localhost:3306/trafy_inventory" -Ddb.user="root" -Ddb.password="your_password_here" ...
```

## Demo video
A demo video showcasing the interface and all the features of the Go-Trafy-Inventory app can be found on YouTube. Click on the image below to watch the video:

[![Trafy - Inventory Management App](https://img.youtube.com/vi/IxR1jZhJlJI/0.jpg)](https://youtu.be/watch?v=IxR1jZhJlJI "Trafy - Inventory Management App")
