# Run in PowerShell on YOUR laptop. Creates D:\Jaya Aswin and copies the Java files into it.
$dir = "D:\Jaya Aswin"
New-Item -ItemType Directory -Force -Path $dir | Out-Null
Copy-Item "$PSScriptRoot\*.java" $dir -Force
Set-Location $dir
Write-Host "Folder ready: $dir`n"
Write-Host "Run these one at a time and screenshot each (Win+Shift+S):`n"
@"
ipconfig
ping www.google.com
tracert www.google.com
nslookup www.youtube.com
netstat
getmac
javac CycleRedundancy.java ; java CycleRedundancy
javac Arp.java ; java Arp
javac Rarp.java ; java Rarp
javac Distance.java ; java Distance
javac LinkState.java ; java LinkState
"@ | Write-Host
