# Coding Practice

Java solutions for algorithms and data structures, with interactive browser visualizations hosted on GitHub Pages.

## Visualizations

👉 **[View all visualizations](https://rakushwa2401.github.io/coding-practice/)**

| Problem | Category | Link |
|---------|----------|------|
| Valid Parentheses Grid | Dynamic Programming | [View](https://rakushwa2401.github.io/coding-practice/dp/ValidParenthesesGrid.html) |

## Running Java Solutions

**Prerequisites:** Java 21, Gradle (via wrapper)

```bash
# Run a specific class (change mainClass in build.gradle.kts first)
./gradlew run

# Or run directly from compiled classes
java -cp bin/main dp.ValidParenthesesGridWithDP
```

To run a different class, update `mainClass` in `build.gradle.kts`:
```kotlin
application {
    mainClass = "package.ClassName"
}
```

## Project Structure

```
coding-practice/
├── docs/                          # GitHub Pages — visualizations
│   ├── index.html                 # Homepage
│   └── dp/
│       └── ValidParenthesesGrid.html
├── src/main/java/                 # Java source
│   ├── dp/
│   ├── blind75/
│   ├── liked100/
│   ├── slidingwindow/
│   ├── tree/
│   ├── graph/
│   └── ...
└── build.gradle.kts
```

## Adding a New Visualization

1. Create your HTML file at `src/main/java/<package>/<ProblemName>Visualization.html`
2. Copy it to `docs/<package>/<ProblemName>.html`
3. Add an entry to the `VISUALIZATIONS` array in `docs/index.html`:

```js
{
  category: "dp",
  categoryLabel: "Dynamic Programming",
  dotClass: "dot-dp",
  title: "Your Problem Title",
  desc: "Short description of what the visualization shows.",
  tags: ["tag1", "tag2"],
  path: "dp/YourProblem.html"
}
```

## GitHub Pages Setup

1. Push this repo to GitHub
2. Go to **Settings → Pages**
3. Under **Source**, select:
   - Branch: `main`
   - Folder: `/docs`
4. Click **Save**
5. Your site will be live at `https://<your-username>.github.io/coding-practice/`
