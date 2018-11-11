## Sudoku
Just another Sudoku solver project playground

# Zelle mit Optionen
- der Sudoku Solver zeigt erst tabellarisch die Optionen, beim Klick wird ein editfield draus

## UI

# Das Modell in der HTML Form
Die neun Quadrate mit ihren Schlüsseln in der SudokuForm`

````
11 12 13
21 22 23
31 32 33
````

Der gleichförmige Aufbau der neun Quadrate

````
a1 b1 c1  a1 b1 c1  a1 b1 c1
a2 b2 c2  a2 b2 c2  a2 b2 c2
a3 b3 c3  a3 b3 c3  a3 b3 c3

a1 b1 c1  a1 b1 c1  a1 b1 c1
a2 b2 c2  a2 b2 c2  a2 b2 c2
a3 b3 c3  a3 b3 c3  a3 b3 c3

a1 b1 c1  a1 b1 c1  a1 b1 c1
a2 b2 c2  a2 b2 c2  a2 b2 c2
a3 b3 c3  a3 b3 c3  a3 b3 c3
````

# Beispiele für Importe
- Der Sudoku Solver bietet an: 81 Nummern, 0, * oder . als "Zelle nicht gefüllt"
- 000079065000003002005060093340050106000000000608020059950010600700600000820390000
- 300401076602500040000006210500000180700010002021000007054300000090004608830109004 ein einfaches
- 000012300000400000105006700306000070700080009020000108001500403000001000003890000 auch einfach 

```
6 0 8 0 9 5 1 0 0
0 0 0 0 0 7 0 0 8
1 4 0 6 0 0 2 0 5
3 0 2 8 5 0 0 0 1
8 5 0 0 0 1 3 6 0
4 0 0 0 0 0 0 0 0
0 0 0 0 0 0 7 1 0
0 2 3 7 1 4 9 0 0
7 0 4 9 8 0 0 2 0
```

## Modell für Berechnungen

- steckt im Package Domain
- Die Klasse SudokuPlayground enthält eine 9x9 Matrix der Zellen.
- X wächst nach links, Y nach unten!!!
- SudokuCell weiß, in welche Zeile / Spalte / Sektor sie gehört.

# Größere Projekte
- Android App
- Docker
- Constraint Programming für die vollständige und direkte Lösung eines Sudoku
- debug level per JMX  XXX erledigt per SpringBootAdmin
- Persistenz

# ToDos
- Hidden Singles als Strategie implementieren, XXXX erledigt
- Playground constructor refactoring ??? keine richtige Idee XXXX erledigt
- calculators package Testabdeckung XXXX erledigt
- Strategie-Auswahl am Client  XXXX erledigt
- "Gelöst"-Zustand erkennen und signalisieren XXXX erledigt
- debug level per JMX  XXX erledigt per SpringBootAdmin
- Strategien nebeneinander in der UI anbieten, nicht nur eine für ein Spiel

# 11.11.2018
- Rekursiv war doch nicht die Lösung, die Werte in der Nachbarschaft einer Zelle waren bislang
	statisch, die müssen aber in jedem Schritt aktualisiert werden
- Das Prisma 4.11. kann tatsächlich nur mit der BUG strategie gelöst werden, die nicht mehr
	intuitiv ist
- Komisch ist, daß die Aktionen clear / calc / single sowohl in jeder Iteration im ResponseBuilder,
	als auch in SudokuCell ausgeführt werden müssen, sonst kommt es immer zu Fehler mit den Options. 

# 27.10.2018
- Die Abweichung zwischen UI und Backend zeigt auf ein tieferes Problem: durch die
	iterative "flache" Berechnung auf dem ganzen Playground erwischt man nicht die Änderungen
	an den Zellen, die schon durch die Iteration sind. Also geht das ganze tatsächlich nur 
	rekursiv richtig.
	Und das funktioniert tatsächlich => SudokuCell.setHiddenSinglesAsValues
	Wenn man "hoddel" mit "obvious" und "hidden" versucht zu lösen, sieht man, daß "hidden"
	weiter kommt.

# 21.10.2018
- hidden single strategy läuft noch nicht von allein durch XXXX erledigt
- Fehler in toString? console zeigt immer nur den Original-Zustand
	- Das ist nicht der Original-Zustand, sondern der des Backends; und beim calculateOptions
		wird für Zellen auch mal nur 1 Option ermittelt (aber der value ist noch 0), 
		und die wird IN DER UI zu einem Value!!
- Fehler in sectorValues, enthält 0en XXXXX erledigt
- Zelle braucht die Position! das ist die Identität des domain objects!
- UI gerundet

# 23.09.2018
- hidden single strategy läuft noch nicht von allein durch => debuggen
- UI gerundet

# 02.09.2018
- Spring Boot Admin: funktioniert noch nicht richtig ohne actuator
- XXXX gelöst durch richtiges expose der endpoints
- und cloud discovery wäre auch besser


# 19.08.2018
- Playground constructor refactoring ??? keine richtige Idee; wäre tatsächlich
eine große Nummer
- Strategie-Auswahl vorbereitet
- Kleinigkeiten

# 12.08.2018
- wieder reinkommen

# 17.06.2018
- automatisch lösen
-    in ObviousSinglesStrategy sind bislang nur die Zeilen implementiert XXXX erledigt


# 10.06.2018
- automatisch lösen
-    isSolved noch testen!! XXXX erledig
-    bricht immer nach einem Durchlauf ab XXXX erledigt

 
# 15.04.2018
- mit Backend für Optionen verhält sich die Anwendung jetzt idempotent
- nächster Schritt: die errechneten Optionen in das UI bringen

# 19.02.2018
- next steps
- leeres Sudoku XXXX erledigt
- lade eines aus einem JSON XXXX erledigt
 
  
# 11.02.2018
interaction flow
- Start: leeres Sudoku, 2 Optionen: selber eintragen, vorhandenes laden
	- redirect index auf sudoku
	- Jedes Feld hat entweder ein input mit 1 Zahl drin, oder n Radiobuttons mit den möglichen Zahlen für dieses Feld.
- in den Feldern mit den Radios wird einer ausgewählt, es können mehrere Felder gleichzeitig geändert werden.
	- Eine Zahl kann immer geändert werden (am Anfang ignorieren)
- submit
- auf dem Server
	- werden die Optionen für jedes Feld neu berechnet

# 28.01.2018
- an github angebunden

# 07.01.2018
  - Jetzt muss ich statt ModelAndView mit Model arbeiten
  - siehe https://hellokoding.com
  - ModelAndView ist nur für get quasi readonly
  


# Strategien
## Hidden Singles
	Beispiel: eine Zeile enthält 3 freie Zellen, 1 links, 2 mitte, die 2 enthalten jeweils
	4 als Option; im Block links ist 4 nur einmal Option, aber in einer anderen Zeile >
	das muss ein Single sein
	verallgemeinert: wenn eine Zahl über row/col/box nur einmal vorkommt, dann
	ist das ein hidden single - ist noch nicht implementiert!! aber einfach
# Freemarker
  - spring.ftl wird live gefunden, aber im FreemarkerTest nicht
  - interessant zu wissen wäre, ob man der Freemarker-Config mehrere Pfade für Templates übergeben kann, und wenn ja, in welchem Format
  - Links
      - (https://freemarker.apache.org/docs/pgui_config_templateloading.html)
      - (https://gist.github.com/moravcik/3859062)
      - (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/view/freemarker/FreeMarkerConfigurer.html)
      - (https://stackoverflow.com/questions/26589229/how-do-i-specify-multiple-templateloaderpaths-for-freemarker-in-spring-boot)
      
# Spring Binding mit Freemarker
- Anwendung von binding im Freemarker Template: https://stackoverflow.com/questions/28770050/binding-form-freemarker-spring-mvc
- echtes Beispiel mit Spring in Freemarker-Syntax: https://gist.github.com/jkuipers/5658672

# Request Mapping
- https://www.journaldev.com/3358/spring-requestmapping-requestparam-pathvariable-example

# Diverse Snippets

			<@spring.bind "sudokuForm.strategy" />
			<@spring.formSingleSelect "sudokuForm.strategy", strategyList, 'style="text-align-all:center;border:0px;border-radius:10px;width:300px;height:50px;background-color:GREENYELLOW;font-size:15px;"' />

- sudokuForm.sudokuRows[${sudokuRow_index}].sudokuCols[${sudokuCol_index}].
- <@spring.bind path="sudokuSquares[sudokuSquare_index].a1"/>
                  <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}" />
                  
<body>
  <h2 class="hello-title">Hello first Sudoku!</h2>
  <@spring.bind "sudokuForm"/>
  <form action="" method="POST">
    <table style="border:1px;margin-left:20%;">
    <#list sudokuForm.sudokuRows as sudokuRow, sudokuCols>
      <tr> <!-- Zeile mit 3 Zeilen von Quadraten -->
        <#list sudokuCols as sudokuCol, square>
        <td>
            <table style="border:2px;margin:none;"> <!-- das 9x9 Zellen Quadrat -->
	          <tr>
	            <td class="cell">${square.a1}
                </td>
	            <td class="cell">${square.b1}</td>
	            <td class="cell">${square.c1}</td>
              </tr>
	          <tr>
	            <td class="cell">${square.a2}</td>
	            <td class="cell">${square.b2}</td>
	            <td class="cell">${square.c2}</td>
              </tr>
	          <tr>
	            <td class="cell">${square.a3}</td>
	            <td class="cell">${square.b3}</td>
	            <td class="cell">${square.c3}</td>
              </tr>
	  	    </table>
        </td>
        </#list>
      </tr>
    </#list>
    </table>
    <input type="submit" value="submit"/>
  </form>  
</body>


								<#else>
									<textarea rows="3" cols="3" name="${spring.status.expression}" >
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "B1">
											<#assign x>
												<#list value as key, option>
													${option}
												</#list>
											</#assign>
										</#if>
					  			</#list>
									</textarea>
								</#if>
								
								
								
			<@spring.bind path="sudokuForm.importSudoku"/>
			<textarea class="numberlist" type="text" name="${spring.status.expression}" value="${spring.status.value}" />

