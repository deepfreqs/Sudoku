<#import "spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start a Sudoku!</title>
    <style>

      table.nope {
        table-layout:fixed;
        margin-left:10%;
      }
      tr.nope {
        height:600px;
      }
      td.cell {
        width:60px;
        height:60px;
        border:1px solid blue;
        overflow:hidden;
        text-align-all:center;
        margin:none;
        font-size:30px;
      }

    </style>
</head>


<body>
  <h2 class="hello-title">Hello first Sudoku!</h2>
  <@spring.bind "sudokuForm"/>
  <form action="" method="POST">
    <table style="border:1px;margin-left:20%;">
    <#assign seq = ['11', '12', '13', '21', '22', '23', '31', '32', '33']>
    <#list seq?chunk(3) as row>
      <tr> <!-- Zeile mit 3 Zeilen von Quadraten -->
        <#list row as cell>
        <td>
            <table style="border:2px;margin:none;"> <!-- das 9x9 Zellen Quadrat -->
	          <tr>
	            <td class="cell">
	              <@spring.bind path="sudokuForm.sudokuSquares[${cell}].a1"/>
	              <#if spring.status.value??>
                  <input type="text" name="${spring.status.expression}" value="${spring.status.value}" />
	              <#else>
                  no value
                  </#if>
                </td>
	            <td class="cell">
	              <@spring.bind path="sudokuForm.sudokuSquares[${cell}].b1"/>
	              <#if spring.status.value??>
                  <input type="text" name="${spring.status.expression}" value="${spring.status.value}" />
	              <#else>
	              <@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
                  <#list spring.status.value as key, value>
                    <#if key = "B1">
                      <@spring.formMultiSelect "sudokuForm.sudokuSquares[${cell}].b1", value, ""/>
                    </#if>
                  </#list>
                  </#if>
	            </td>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].c1}</td>
              </tr>
	          <tr>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].a2}</td>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].b2}</td>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].c2}</td>
              </tr>
	          <tr>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].a3}</td>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].b3}</td>
	            <td class="cell">${sudokuForm.sudokuSquares[cell].c3}</td>
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
</html>