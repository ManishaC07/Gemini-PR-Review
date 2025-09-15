## General Coding Standards

- Use TypeScript exclusively, avoiding `any`.
- Favor functional and React Server Components.
- Implement robust error boundaries and accessibility practices (a11y).
- Apply proper internationalization (i18n) techniques.

## Input Validation
- All user inputs must be validated and sanitized.
- Avoid direct use of user input in SQL queries. Use parameterized queries.
- CWE-89: SQL Injection
 
## Authentication & Authorization
- Ensure all endpoints require proper authentication.
- Avoid hardcoded credentials.
- CWE-798: Use of Hard-coded Credentials
 
## Error Handling
- Do not expose internal error messages to users.
- CWE-209: Information Exposure Through an Error Message
 
## Cryptography
- Use strong, industry-standard encryption algorithms.
- Avoid custom cryptographic implementations.
- CWE-327: Use of a Broken or Risky Cryptographic Algorithm
