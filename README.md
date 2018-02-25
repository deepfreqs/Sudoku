# Sudoku
Just another Sudoku solver project playground

19.02.2018
- next steps
  - leeres Sudoku
  - lade eines aus einem JSON
  
  
11.02.2018
interaction flow
- Start: leeres Sudoku, 2 Optionen: selber eintragen, vorhandenes laden
	- redirect index auf sudoku
	- Jedes Feld hat entweder ein input mit 1 Zahl drin, oder n Radiobuttons mit den möglichen Zahlen für dieses Feld.
- in den Feldern mit den Radios wird einer ausgewählt, es können mehrere Felder gleichzeitig geändert werden.
	- Eine Zahl kann immer geändert werden (am Anfang ignorieren)
- submit
- auf dem Server
	- werden die Optionen für jedes Feld neu berechnet

28.01.2018
- an github angebunden

Stand 7.1.
  - Jetzt muss ich statt ModelAndView mit Model arbeiten
  - siehe https://hellokoding.com
  - ModelAndView ist nur für get quasi readonly
  
Vorgehen
- initForm macht man wohl per GET, siehe auch Spring MVC Blueprints    
- Databinding beim POST
- das als JSON 
- Controller-Methode für die Aufnahme


Freemarker
  - spring.ftl wird live gefunden, aber im FreemarkerTest nicht
  - interessant zu wissen wäre, ob man der Freemarker-Config mehrere Pfade für Templates übergeben kann, und wenn ja, in welchem Format
  - Links
      - (https://freemarker.apache.org/docs/pgui_config_templateloading.html)
      - (https://gist.github.com/moravcik/3859062)
      - (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/view/freemarker/FreeMarkerConfigurer.html)
      - (https://stackoverflow.com/questions/26589229/how-do-i-specify-multiple-templateloaderpaths-for-freemarker-in-spring-boot)
      
Spring Binding mit Freemarker
- Anwendung von binding im Freemarker Template: https://stackoverflow.com/questions/28770050/binding-form-freemarker-spring-mvc
- echtes Beispiel mit Spring in Freemarker-Syntax: https://gist.github.com/jkuipers/5658672

Request Mapping
  - https://www.journaldev.com/3358/spring-requestmapping-requestparam-pathvariable-example

Diverse Snippets
      
sudokuForm.sudokuRows[${sudokuRow_index}].sudokuCols[${sudokuCol_index}].

	              <@spring.bind path="sudokuSquares[sudokuSquare_index].a1"/>
                  <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}" />

    
    
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