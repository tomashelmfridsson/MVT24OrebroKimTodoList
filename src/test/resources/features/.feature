Feature: Lägga till uppgifter i todolistan

  Background:
    Given jag har en todolista

  Scenario Outline: Användaren lägger till en ny uppgift
    When användaren lägger till en uppgift med beskrivningen "<description>"
    Then uppgiften ska ha beskrivningen "1. [ ] <description>"

    Examples:
      | description      |
      | Städa huset      |
      | Köpa mjölk       |
      | Gå ut med hunden |
      | Träna på gymmet  |
      | Skriva rapport   |


  Scenario: Användaren markerar en uppgift som klar
    Given användaren lägger till en uppgift med beskrivningen "Städa huset"
    When  användaren markerar uppgiften 0 som klar
    Then  ska uppgiften vara markerad som klar


  Scenario: Kontrollera antalet uppgifter
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    Then Uppgifter i todolista ska stämma 2

  Scenario: Kontrollera antalet genomförda uppgifter
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    * användaren markerar uppgiften 0 som klar
    Then antalet genomförda uppgifter ska vara 1

  Scenario: genomför samma fler gånger
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren markerar uppgiften 0 som klar
    * användaren markerar uppgiften 0 som klar
    Then antalet genomförda uppgifter ska vara 1

  Scenario: Gör klart hela listan, men genomför ytterligare en task
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    * användaren markerar uppgiften 0 som klar
    * användaren markerar uppgiften 1 som klar
    * användaren markerar uppgiften 2 som klar
    Then antalet genomförda uppgifter ska vara 2
    And listan ska var klar

  Scenario: Genomför något som inte finns i listan
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren markerar uppgiften 1 som klar
    Then antalet genomförda uppgifter ska vara 0
    And listan ska inte vara klar

  Scenario: kontrollerar antalet uppgifter i listan
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    Then antalet uppgifter ska vara 2

  Scenario: radera en uppgift
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren tar bort den uppgiften: 0
    Then antalet uppgifter ska vara 0

  Scenario: Filtrera upgifter basserat på status
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    * användaren markerar uppgiften 0 som klar
    * filtrera uppgifter baserat på status
    Then kontrollera klar 1 inte klar 1

  Scenario: Ändra ordningen på uppgifterna
    When användaren lägger till en uppgift med beskrivningen "Städa huset"
    * användaren lägger till en uppgift med beskrivningen "Köpa mjölk"
    Then ändra ordningen på uppgiften

  Scenario: Användaren markerar en uppgift som klar och avmarkera
    Given användaren lägger till en uppgift med beskrivningen "Städa huset"
    When  användaren markerar uppgiften 0 som klar
    * användaren avmarkerar uppgiften 0 som klar
    Then antalet genomförda uppgifter ska vara 0




