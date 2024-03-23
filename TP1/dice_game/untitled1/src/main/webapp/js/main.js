let rollBtn = document.getElementById("roll-btn");
let score = document.getElementById("current-score");
let rollsLeft = document.getElementById("roll-left");

let rollNbr= 0;
let scoreVal = 0
rollBtn.addEventListener("click",function(e){
     if(rollNbr < 20){
         rollNbr++;
         rollsLeft.innerText = 20 - rollNbr;
         let currentRoleVal = Math.floor(Math.random() * 6) + 1;
         let currentDiv = document.getElementById(`roll-${rollNbr}`);
         currentDiv.innerText = currentRoleVal;
         if(rollNbr != 1){
             let prevDiv = document.getElementById(`roll-${rollNbr-1}`);
             let prevRollVal = prevDiv.innerText;

             if(currentRoleVal == prevRollVal){
                 scoreVal += 20;
                 score.innerText = scoreVal;
                 currentDiv.style.color = "green";
                 prevDiv.style.color = "green";
             }
         }
         if (rollNbr == 20){
             rollBtn.disabled = true
             let rollBtnContainer = document.getElementById("rollBtnContainer");
             rollBtnContainer.innerHTML = `<div class="alert alert-danger p-1 mb-0" style="padding: 5px">Game Completed</div>`;
             setTimeout(function (){
                 let scoreForm = document.getElementById("scoreForm");
                 let scoreInput = document.getElementById("scoreInput");
                 scoreInput.value = scoreVal;
                 scoreForm.submit();
             }, 2000);
         }
     }else {
     }
})
