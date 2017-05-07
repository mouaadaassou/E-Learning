(function(){

  angular.module("mainApp", [])
  .controller("ExerciceController", ExerciceController);


  function ExerciceController(){
      var exercice = this;

      exercice.exe = [1];
      exercice.itemNumber = 1;
      exercice.leng = exercice.exe.length;
      exercice.addQuestion = function(){
        var l = exercice.exe[exercice.exe.length -1];
        exercice.exe.push(l + 1);
        exercice.itemNumber = exercice.exe.length;
      }

      exercice.removeQuestion = function(){
        if(exercice.exe.length > 1){
          exercice.exe.pop();
          exercice.itemNumber = exercice.exe.length;
        }
      }

      
  }

})();
