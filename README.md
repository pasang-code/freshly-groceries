# Freshly 🛒
 
Een online supermarkt met thuislevering — blader door producten, vul je winkelmand en reken af. Ik bouwde dit voor het vak Advanced Programming aan Thomas More, en ontwierp het volledig voor ik één lijn code schreef — de volledige analyse vind je onderaan.
 
**[▶ Probeer de live demo](https://grocery-delivery-webapp-spring-2.onrender.com/)**
<sub>Gratis hosting — de eerste keer laden kan ~50 seconden duren terwijl de server wakker wordt.</sub>
 
<!-- TODO: voeg een echte screenshot toe (homepagina of winkelmand) als images/app-screenshot.png -->
![Screenshot van Freshly](images/app-screenshot.png)
 
## Wat het doet
 
- Producten bekijken, toevoegen aan de winkelmand en afrekenen
- Spring MVC-controllers met een JPA-datamodel
  <!-- Heeft je code een aparte service-laag tussen controllers en repositories?
       Vermeld dat dan — het is een pluspunt. Praten je controllers rechtstreeks
       met repositories, laat deze lijn dan zo staan. Claim geen laag die je
       niet hebt. -->
- Server-side formuliervalidatie
- Draait op een embedded H2-database — clonen en runnen, geen databasesetup nodig
- Multi-stage Docker build, gedeployed op Render
  <!-- Hou deze lijn enkel als je kan uitleggen WAAROM twee stages:
       build stage = Maven + volledige JDK (groot image), runtime stage = enkel
       de jar op een slank JRE-image (klein). Wil je dit nog niet verdedigen,
       verander dan naar: "Gedockerized en gedeployed op Render" -->
## Tech stack
 
Java 24 · Spring Boot 4 (Web MVC, Data JPA, Thymeleaf, Validation) · H2 · Docker
 
## Lokaal draaien
 
**Vereisten:** Java 24 — meer niet. De Maven wrapper en de embedded database doen de rest.
 
```bash
git clone https://github.com/pasang-code/freshly-groceries.git
cd freshly-groceries
./mvnw spring-boot:run        # Windows: mvnw.cmd spring-boot:run
```
 
Of met Docker (geen Java-installatie nodig):
 
```bash
docker build -t freshly .
docker run -p 8080:8080 freshly
```
 
De app draait op `http://localhost:8080`.
 
## Ontwerp & documentatie
 
Ik ontwierp het project voor ik het bouwde — user story map, conceptueel model, wireframes en UML-diagrammen hieronder.
 
### Productbeschrijving
 
Een lokale supermarkt wil haar diensten uitbreiden door een online platform met bezorgservice te ontwikkelen, waarmee klanten hun boodschappen digitaal kunnen bestellen en thuis laten leveren. Deze service is bedoeld voor stadsbewoners, in het bijzonder mensen met een drukke levensstijl, zoals werkende professionals, gezinnen en ouderen, die op een gemakkelijke manier toegang willen tot verse voeding zonder zelf naar de winkel te moeten gaan. Door deze uitbreiding kan de supermarkt haar digitale aanwezigheid vergroten en een nieuwe inkomstenbron creëren, terwijl klanten tijd besparen en genieten van het gemak en de flexibiliteit van thuislevering, met blijvende toegang tot kwalitatieve en verse producten.
 
### User story map
 
![User story map](images/storymap.png)
 
### Conceptueel model
 
![Conceptueel model](images/conceptueelmodelsimpel.png)
 
### Wireframes
 
<!-- TODO: check of deze labels kloppen met wat de wireframes echt tonen -->
![Wireframe 1](images/wf1.png)
![Wireframe 2](images/wf2.png)
 
### Use-case diagram
 
![Use-case diagram](images/usecases2.png)
 
### Activity diagrams
 
![Activity diagram 1](images/activity1.png)
![Activity diagram 2](images/activity2.webp)
 
### Sequence diagram
 
![Sequence diagram](images/sequence-diagram.png)
 
### Class diagram
 
![Class diagram](images/klassediagram.png)
