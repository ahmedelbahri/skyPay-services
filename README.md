# skyPay-services

A banking service implementation featuring account management with transaction tracking and statement generation.

## Features

- **Account Management**: Create accounts with deposit and withdrawal operations
- **Transaction History**: Automatic tracking of all transactions with timestamps
- **Statement Generation**: Print account statements with dynamically aligned columns
- **Exception Handling**: Robust validation for invalid inputs and insufficient funds
- **Performance Optimized**: Efficient ArrayList-based implementation

## Project Structure

```
Banking Service/
├── AccountService.java  - Interface defining banking operations
├── Account.java         - Main implementation with transaction tracking
└── AccountDemo.java     - Demo showcasing functionality and exception handling
```

## Usage

### Compile and Run

```bash
cd "Banking Service"
javac *.java
java AccountDemo
```

### Example Output

```
Date       || Amount || Balance
19/12/2025 || -500   || 2500
19/12/2025 || 2000   || 3000
19/12/2025 || 1000   || 1000
```

## Running Tests

```bash
javac AccountTest.java && java AccountTest
```

All tests include validation for:

- Deposits and withdrawals
- Exception handling (negative amounts, insufficient funds)
- Statement formatting
- Performance (10,000 transactions)

## Implementation Notes

- Money amounts are stored as integers (cents) for precision
- Transactions displayed in reverse chronological order
- Dynamic column alignment based on content width
- ArrayList-based storage for efficient operations
