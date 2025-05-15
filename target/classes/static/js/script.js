document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("loginForm");

  // Sample users data (in a real app, this would be handled by a backend)
  const users = [{ username: "demo", password: "demo123" }];

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Simple authentication
    const user = users.find(
      (u) => u.username === username && u.password === password
    );

    if (user) {
      // Store login state (in a real app, this would be a proper auth token)
      localStorage.setItem("isLoggedIn", "true");
      localStorage.setItem("username", username);

      // Redirect to dashboard
      window.location.href = "dashboard.html";
    } else {
      alert("Invalid username or password");
    }
  });

  // Check if user is already logged in
  if (localStorage.getItem("isLoggedIn") === "true") {
    window.location.href = "dashboard.html";
  }
});
