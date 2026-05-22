# Lab 04 — Kotlin SOLID (OkHttp + jsoup)

Laborator de programare în Kotlin cu accent pe principiile SOLID și design orientat pe interfețe.

## Structura proiectului

```
lab04/
├── src/
│   ├── main/kotlin/ro/tuiasi/pp/lab04/
│   │   ├── crawler/      # Tema 1: Crawler cu injecție de dependențe
│   │   ├── cinema/       # Tema 2: Aplicație cinema SOLID
│   │   └── notes/        # Tema 3: Aplicație notițe CLI
│   └── test/kotlin/ro/tuiasi/pp/lab04/
│       ├── ContentParserTest.kt
│       ├── CinemaServiceTest.kt
│       └── NoteRepositoryTest.kt
├── .github/workflows/classroom.yml
├── build.gradle.kts
├── settings.gradle.kts
├── ASSIGNMENT.md
└── README.md
```

## Principii SOLID aplicate

- **S** — Single Responsibility: fiecare clasă are un singur motiv de schimbare
- **O** — Open/Closed: extensibil prin noi parsere fără modificarea Crawler
- **L** — Liskov Substitution: orice `CinemaRepository` poate înlocui `InMemoryCinemaRepository`
- **I** — Interface Segregation: interfețe separate pentru repository și serviciu
- **D** — Dependency Inversion: `Crawler` depinde de abstractizarea `ContentParser`

## Cum rulezi

```bash
gradle test
```

## Cerințe sistem

- JDK 21 (Temurin recomandat)
- Gradle 8.11+ (sau IntelliJ cu suport Gradle)

## Citește mai mult

Vezi [ASSIGNMENT.md](ASSIGNMENT.md) pentru cerințele complete ale temelor.
