@echo off
setlocal

:menu
echo =============================
echo   Microservices Build Menu
echo =============================
echo 1. Build all projects
echo 2. Run demo-1
echo 3. Run demo-2
echo 4. Run demo-3
echo 5. Run all demos
echo 6. Stop all demos
echo 7. Exit
echo =============================
choice /c 1234567 /n /m "Select an option (1-7): "
set opt=%errorlevel%

if %opt%==1 goto build
if %opt%==2 goto rundemo1
if %opt%==3 goto rundemo2
if %opt%==4 goto rundemo3
if %opt%==5 goto runall
if %opt%==6 goto stopall
if %opt%==7 goto end

:build
echo Building demo-1...
cd demo-1
call mvnw clean package -DskipTests
if %errorlevel% neq 0 exit /b %errorlevel%
cd ..

echo Building demo-2...
cd demo-2
call mvnw clean package -DskipTests
if %errorlevel% neq 0 exit /b %errorlevel%
cd ..

echo Building demo-3...
cd demo-3
call mvnw clean package -DskipTests
if %errorlevel% neq 0 exit /b %errorlevel%
cd ..

echo All projects built successfully.
goto menu

:rundemo1
echo Starting demo-1: demo-1\target\demo1-1.0.jar
start "demo-1" cmd /c "java -jar demo-1\target\demo1-1.0.jar & pause"
goto menu

:rundemo2
echo Starting demo-2: demo-2\target\demo2-1.0.jar
start "demo-2" cmd /c "java -jar demo-2\target\demo2-1.0.jar & pause"
goto menu

:rundemo3
echo Starting demo-3: demo-3\target\discovery-server-1.0.jar
start "demo-3" cmd /c "java -jar demo-3\target\discovery-server-1.0.jar & pause"
goto menu

:runall
echo Starting demo-1: demo-1\target\demo1-1.0.jar
start "demo-1" cmd /c "java -jar demo-1\target\demo1-1.0.jar & pause"
echo Starting demo-2: demo-2\target\demo2-1.0.jar
start "demo-2" cmd /c "java -jar demo-2\target\demo2-1.0.jar & pause"
echo Starting demo-3: demo-3\target\discovery-server-1.0.jar
start "demo-3" cmd /c "java -jar demo-3\target\discovery-server-1.0.jar & pause"
goto menu

:stopall
echo Stopping all demo Java processes...
for %%T in (demo-1 demo-2 demo-3) do (
    for /f "tokens=2 delims==; " %%P in ('tasklist /v /fi "imagename eq java.exe" /fi "windowtitle eq %%T" /fo list ^| find "PID"') do (
        echo Killing %%T PID %%P
        taskkill /F /PID %%P
    )
)
echo All demo Java processes stopped.
goto menu

:end
endlocal
exit /b