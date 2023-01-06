class Solution {
    fun solution(t: String, p: String): Int {
        
        // 길이 10000까지의 문자열이 들어오므로
        // Long 형식 사용

        var answer: Int = 0
        var pNum = p.toLong()
        
        for (idx in 0 until (t.length - p.length) + 1) {       
            var subNum = t.substring(idx, idx + p.length).toLong()
            
            if (subNum <= pNum) {
                answer += 1
            }
        }
        
        
        return answer
    }
}