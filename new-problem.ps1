param(
    [string]$Number,
    [string]$Name,
    [string]$Topic = "DSA\Array"
)

$folder = "$Topic\${Number}_$Name"

New-Item -ItemType Directory -Path $folder -Force | Out-Null
New-Item -ItemType Directory -Path "$folder\Java" -Force | Out-Null
New-Item -ItemType Directory -Path "$folder\CPP" -Force | Out-Null
New-Item -ItemType Directory -Path "$folder\Python" -Force | Out-Null

New-Item -ItemType File -Path "$folder\Java\Solution.java" -Force | Out-Null
New-Item -ItemType File -Path "$folder\CPP\solution.cpp" -Force | Out-Null
New-Item -ItemType File -Path "$folder\Python\solution.py" -Force | Out-Null
New-Item -ItemType File -Path "$folder\README.md" -Force | Out-Null

Write-Host "Created $folder"