document.addEventListener("DOMContentLoaded", () => {
  // Check authentication
  if (localStorage.getItem("isLoggedIn") !== "true") {
    window.location.href = "index.html";
    return;
  }

  // Set welcome message
  const username = localStorage.getItem("username");
  const welcomeText = document.querySelector(".welcome-text");
  if (welcomeText && username) {
    welcomeText.textContent = `welcome ${username}`;
  }

  // Gallery navigation
  const gallery = document.querySelector(".gallery");
  const nextBtn = document.querySelector(".gallery-nav.next");

  if (nextBtn && gallery) {
    nextBtn.addEventListener("click", () => {
      gallery.scrollBy({
        left: 160,
        behavior: "smooth",
      });
    });
  }

  // Add creation button
  const addBtn = document.querySelector(".add-btn");
  if (addBtn) {
    addBtn.addEventListener("click", () => {
      // In a real app, this would open a file upload dialog or creation interface
      alert("Add new creation feature would go here!");
    });
  }

  // Sample connections data (in a real app, this would come from a backend)
  const connections = [
    { id: 1, name: "User 1" },
    { id: 2, name: "User 2" },
    { id: 3, name: "User 3" },
  ];

  // Add click handlers to connection avatars
  const connectionItems = document.querySelectorAll(".connection-item");
  connectionItems.forEach((item, index) => {
    if (connections[index]) {
      item.addEventListener("click", () => {
        alert(`Viewing ${connections[index].name}'s profile`);
      });
      item.style.cursor = "pointer";
    }
  });
});
