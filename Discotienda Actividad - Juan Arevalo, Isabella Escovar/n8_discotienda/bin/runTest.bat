@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogota - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Todos los derechos reservados 2005
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2
REM Ejercicio: n7_discotienda
REM Autor: Nicolás López - 06/12/2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/



REM ---------------------------------------------------------
REM Ejecucion de la prueba
REM ---------------------------------------------------------

cd ..
java -classpath ./lib/discotienda.jar;./test/lib/discotiendaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.discotienda.test.DiscotiendaTest
java -classpath ./lib/discotienda.jar;./test/lib/discotiendaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.discotienda.test.DiscoTest
java -classpath ./lib/discotienda.jar;./test/lib/discotiendaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.discotienda.test.CancionTest
cd bin