@echo off
setlocal
python "%~dp0trimos.py" %*
if errorlevel 1 pause
endlocal
