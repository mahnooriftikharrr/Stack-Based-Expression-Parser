<!-- 🧮 Animated Header -->

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=26&duration=3000&pause=800&color=FF69B4&center=true&vCenter=true&width=850&lines=🧮+Stack-Based+Expression+Parser;Evaluating+Infix+Expressions+Using+Stacks;Algorithms+%7C+Data+Structures+%7C+Parsing+💻" alt="Typing Animation" />
</p>

---

# 🧠 Stack-Based Expression Parser – Arithmetic Evaluation in Java

This project implements a **stack-based algorithm** to evaluate **infix arithmetic expressions** such as:

```
(1 + 2) * 3
7 - 3 * 2
7 * 2 ^ 3 + 1
```

The program demonstrates the use of **data structures**, **operator precedence**, and **algorithmic parsing** to compute results from mathematical expressions — mimicking how **interpreters and compilers** handle syntax evaluation.

Built entirely in **Java**, this project solidified my understanding of **Stacks**, **tokenization**, **control flow**, and **expression parsing logic**.

---

## 🎯 Project Overview

### Goal:

To evaluate arithmetic expressions by separating them into **tokens** and processing them with two stacks —

* An **operand stack** for numbers
* An **operator stack** for symbols like `+`, `-`, `*`, `/`, `^`, `(`, `)`

The algorithm follows the **infix evaluation model**, where operator precedence and associativity rules determine the computation order.

---

## ⚙️ Core Algorithm

### 🧩 Tokenization

Expressions are split into **tokens** using spaces as delimiters.
Each token is classified as either an **operand** or an **operator**.

```java
String[] tokens = expression.split("\\s+");
```

---

### 🧱 Stacks

Two stacks are used throughout the process:

* `Stack<Integer> operandStack` – stores numbers
* `Stack<Character> operatorStack` – stores operators

---

### 🔁 Evaluation Steps

1. **Read tokens left to right.**
2. **If operand →** push onto the operand stack.
3. **If operator →**

   * Compare its precedence with the top of the operator stack.
   * While the top operator has **equal or higher precedence**, process it:

     * Pop two operands
     * Apply the operator
     * Push the result back.
4. Push the new operator.
5. After reading all tokens, process the remaining operators.

---

### 🧮 Precedence Order

| Operator | Precedence | Description              |
| -------- | ---------- | ------------------------ |
| `^`      | Highest    | Exponentiation           |
| `*`, `/` | Medium     | Multiplication, Division |
| `+`, `-` | Lowest     | Addition, Subtraction    |

Parentheses override the natural order to ensure expressions like `(1 + 2) * 3` are correctly evaluated.

---

### ✨ Example

**Expression:**

```
7 - 3 * 2
```

**Operand Stack:** `[7, 3, 2]`
**Operator Stack:** `[-, *]`
→ Multiplication is evaluated first → 3 * 2 = 6
→ Then subtraction → 7 - 6 = 1

✅ **Result:** 1

---

### 🔍 Extended Version – Parentheses Support

To earn the “E” extension grade, I enhanced the program to **support parentheses**, ensuring sub-expressions are handled first:

**Algorithm Modifications:**

* `(` is always pushed to the operator stack (lowest precedence).
* When `)` is encountered → process operators until the matching `(` is found.

---

## 🧪 Example Runs

| Expression      | Output |
| --------------- | ------ |
| `1 + 2 * 3`     | 7      |
| `(1 + 2) * 3`   | 9      |
| `7 - 3 * 2`     | 1      |
| `7 * 2 ^ 3 + 1` | 57     |

---

## 🧩 Data Structures & Concepts

| Concept                     | Description                                    |
| --------------------------- | ---------------------------------------------- |
| 🧱 **Stack**                | LIFO structure for operands and operators      |
| 🧩 **Tokenization**         | Splitting input expression into atomic symbols |
| ⚙️ **Algorithm Design**     | Stepwise infix parsing logic                   |
| 🧮 **Operator Precedence**  | Hierarchical evaluation order                  |
| 💡 **Parentheses Handling** | Implements nested subexpression control        |
| 🔄 **Control Flow**         | Iterative stack-based reduction                |

---

## 🧠 Learning Outcomes

✅ Gained hands-on experience using **Stacks** for real-world parsing applications.
✅ Strengthened my understanding of **operator precedence** and **expression evaluation.**
✅ Learned how **tokenization and parsing** relate to compiler design.
✅ Implemented **error handling and validation** for malformed expressions.
✅ Improved **modular coding practices** with private helper methods.

---

## 💼 Technical Skills

| Category               | Skills                                              |
| ---------------------- | --------------------------------------------------- |
| 💻 **Languages**       | Java                                                |
| 📚 **Core Concepts**   | Data Structures (Stacks), Parsing, Algorithm Design |
| ⚙️ **Tools**           | IntelliJ IDEA CE, JUnit                             |
| 🧠 **CS Foundations**  | Compiler theory, Expression evaluation              |
| 🧩 **Problem Solving** | Logical reasoning, abstraction, debugging           |

---

## 🌟 Reflection

This project gave me a strong intuition for **how programming languages interpret code** and how **data structures like stacks power syntax parsing** in compilers and interpreters.

---

## 👩🏻‍💻 Author

**Mahnoor Iftikhar**
📍 *Pacific Lutheran University* – Computer Science & Economics, Data Science Minor
💡 Learned more about **compiler logic, algorithms, and backend systems**.

📫 [LinkedIn](https://www.linkedin.com/in/mahnooriftikharrr)
📧 [mahnooriftikharr@gmail.com](mailto:mahnooriftikharr@gmail.com)

