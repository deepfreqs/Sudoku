# Sudoku
Just another Sudoku solver project playground

28.01.2018
- an github angebunden

Stand 7.1.
- spring.ftl wird live gefunden, aber im FreemarkerTest nicht
  - interessant zu wissen wäre, ob man der Freemarker-Config mehrere Pfade für Templates übergeben kann, und wenn ja, in welchem Format
- Jetzt muss ich statt ModelAndView mit Model arbeiten
  - siehe https://hellokoding.com
  - ModelAndView ist nur für get quasi readonly
  
  
Vorgehen
- initForm macht man wohl per GET, siehe auch Spring MVC Blueprints    
- Databinding beim POST
- das als JSON 
- Controller-Methode für die Aufnahme
? wie geht das zusammen mit Freemarker?