const depositButton = document.getElementById('depositButton');
const withdrawButton = document.getElementById('withdrawButton');
const amountInput = document.getElementById('amount');
const balanceDisplay= document.getElementById('balance');
const transferButton = document.getElementById("TransferButton");
console.log("JavaScript is running");
depositButton.addEventListener("click", async function() {
    const amount = amountInput.value;

    const response = await fetch(
        "/api/deposit?amount=" + encodeURIComponent(amount),
        {
            method: "POST"
        }
    );

    if (!response.ok) {
        alert("Deposit failed");
        return;
    }

    const balance = await response.json();
    balanceDisplay.textContent = "€" + balance.toFixed(2);
});
withdrawButton.addEventListener("click", async function() {
    const amount = amountInput.value;

    const response = await fetch(
        "/api/withdraw?amount=" + encodeURIComponent(amount),
        {
            method: "POST"
        }
    );

    if (!response.ok) {
        alert("Withdrawal failed");
        return;
    }

    const balance = await response.json();
    balanceDisplay.textContent = "€" + balance.toFixed(2);
});
async function loadBalance() {
    const response = await fetch("/api/balance");
    const balance = await response.json();

    balanceDisplay.textContent = "€" + balance.toFixed(2);
}

loadBalance();
async function loadTransactions() {
    const response = await fetch("/api/transactions");
    const transactions = await response.json();

    const transactionList = document.getElementById("transactionList");

    transactionList.innerHTML = "";

    transactions.forEach(function(transaction) {
        const item = document.createElement("li");

        item.textContent =
            transaction.type + ": €" + transaction.amount;

        transactionList.appendChild(item);
    });
}

loadTransactions();

transferButton.addEventListener("click", async function() {
    const amount = amountInput.value;

    const response = await fetch(
        "/api/transfer?amount=" + encodeURIComponent(amount),
        { method: "POST" }
    );

    if (!response.ok) {
        alert("Transfer failed");
        return;
    }

    const balance = await response.json();
    balanceDisplay.textContent = "€" + balance.toFixed(2);
});



