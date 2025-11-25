@echo off
setlocal

REM Check for RUN argument
set RUNMODE=0
if /I "%1"=="RUN" set RUNMODE=1

REM Build all projects
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

if %RUNMODE%==1 (
	echo Running all projects...
	echo Starting demo-1: demo-1\target\demo1-1.0.jar
	start "demo-1" cmd /c "java -jar demo-1\target\demo-1-1.0.jar "
	echo Starting demo-2: demo-2\target\demo2-1.0.jar
	start "demo-2" cmd /c "java -jar demo-2\target\demo2-1.0.jar "
	echo Starting demo-3: demo-3\target\discovery-server-1.0.jar
	start "demo-3" cmd /c "java -jar demo-3\target\discovery-server-1.0.jar "
	echo All projects started.
) else (
	echo To run all projects, use: build.bat RUN
)
endlocal