const copyButton = document.querySelector("#copy");

copyButton.addEventListener("click", function () {
  const resInput = document.getElementById("res-url");
  resInput.select();
  window.document.execCommand("copy");
  alert("Copied!");
});
