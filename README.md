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
- SudokuCell weiß, in welche Zeile / Spalte / Sektor sie gehört.

# ToDos
- Algorithmus verbessern (Optionen sind noch nicht fehlerfrei)
- "Gelöst"-Zustand erkennen und signalisieren
- Android App
- Docker
- implementiere Iterator für Playground
- Constraint Programming für die vollständige und direkte Lösung eines Sudoku
- debug level per JMX


# 10.06.2018
- automatisch lösen
-    isSolved noch testen!!
-    bricht immer nach einem Durchlauf ab

 
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

