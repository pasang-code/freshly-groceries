# Freshly 🛒

An online grocery shop with home delivery — browse products, fill your cart, and check out. I built this for the Advanced Programming course at Thomas More, and designed it before writing any code — the full analysis is at the bottom.

**[▶ Try the live demo](https://grocery-delivery-webapp-spring-2.onrender.com/)**
<sub>Free hosting — the first load can take ~50 seconds while the server wakes up.</sub>

<!-- TODO: add a real screenshot (homepage or cart view) as images/app-screenshot.png -->
![Freshly screenshot](images/app-screenshot.png)

## What it does

- Browse products, add them to a cart, and check out
- Spring MVC controllers with a JPA data model
  <!-- If your code has a separate service layer between controllers and
       repositories, say so — it's a plus. If controllers talk straight to
       repositories, leave this line as is. Don't claim the layer you don't have. -->
- Server-side form validation
- Runs with an embedded H2 database — clone and run, no database setup
- Multi-stage Docker build, deployed on Render
  <!-- Keep this line only once you can explain WHY two stages:
       build stage = Maven + full JDK (big), runtime stage = just the jar on a
       slim JRE image (small). If you'd rather not defend it yet, change to:
       "Dockerized and deployed on Render" -->

## Tech stack

Java 24 · Spring Boot 4 (Web MVC, Data JPA, Thymeleaf, Validation) · H2 · Docker

## Run it locally

**Prerequisites:** Java 24 — that's it. The Maven wrapper and embedded database handle the rest.

```bash
git clone https://github.com/pasang-code/freshly-groceries.git
cd freshly-groceries
./mvnw spring-boot:run        # Windows: mvnw.cmd spring-boot:run
```

Or with Docker (no Java install needed):

```bash
docker build -t freshly .
docker run -p 8080:8080 freshly
```

The app runs at `http://localhost:8080`.

## What I learned

<!-- Write 3-5 short bullets IN YOUR OWN WORDS. This is the section recruiters
     trust most, precisely because AI can't know it. Prompts to jog you:
     - What took embarrassingly long before it clicked? (JPA relations? Thymeleaf forms?)
     - What would you build differently next time?
     - What broke when you deployed to Render that worked locally?
     Rough sentences beat polished ones here. Delete this comment after. -->

## Design & documentation

I designed the project before building it — user story map, domain model, wireframes and UML below.

### Product description

A local supermarket wants to extend its services with an online ordering and delivery platform, aimed at busy city residents — working professionals, families and elderly customers — who want convenient access to fresh groceries without visiting the store.

### User story map

![User story map](images/storymap.png)

### Conceptual model

![Conceptual model](images/conceptueelmodelsimpel.png)

### Wireframes

<!-- TODO: check these labels match what the wireframes actually show -->
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
