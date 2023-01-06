class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        
        var tempAnswer : MutableList<Int> = mutableListOf()
        var termNameList : MutableList<String> = mutableListOf()
        var termsList : MutableList<Int> = mutableListOf()
        
        
        // 한달은 28일
        // 두 날짜간 차이를 계산        
        var now : List<String> = today.split(".")
        var nowDays : Int = (now[0].toInt() * (28 * 12)) + ((now[1].toInt() - 1) * 28) + now[2].toInt()
        
        // 약관 길이 저장
        for (item in terms) {
            var data : List<String> = item.split(" ")
            termNameList.add(data[0])
            termsList.add(data[1].toInt() * 28)
        }
                
        // 28진수 계산 
        for (index in 0 until privacies.size) {            
            var data : List<String> = privacies[index].split(" ")
            var dayString : List<String> = data[0].split(".")
            var day : Int = (dayString[0].toInt() * (28 * 12)) + ((dayString[1].toInt() - 1) * 28) + dayString[2].toInt()
            
            var diff = nowDays - day
            var idx = termNameList.indexOf(data[1])
            
            if (diff >= termsList[idx]) {
                tempAnswer.add(index + 1)
            }
        }
        
        return tempAnswer.toIntArray()
    }
}