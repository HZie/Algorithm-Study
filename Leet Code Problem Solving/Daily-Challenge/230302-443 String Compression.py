class Solution:
    def compress(self, chars: List[str]) -> int:
        idx = 0
        run = 1
        count = 1
        compressed = 0

        while idx < len(chars):
            
            while run < len(chars) and chars[run] == chars[idx]:
                chars.pop(run)
                count += 1

            idx += 1

            if count > 1:
                c_list = list(str(count))
                for c in c_list:
                    chars.insert(idx, c)
                    idx += 1
            
            print(count)
            count = 1
            run = idx+1

        return len(chars)


# Solution
# 아래의 코드가 가능한 이유는 리트코드가 return으로 size를 하게 했기 때문
# 작성된 것까지의 길이를 리턴하면 거기까지만 리트코드에서 인식하고 출력함

class Solution:
    def compress(self, chars: List[str]) -> int:
        walker, runner = 0, 0
        while runner < len(chars):
		
            chars[walker] = chars[runner]
            count = 1
			
            while runner + 1 < len(chars) and chars[runner] == chars[runner+1]:
                runner += 1
                count += 1
			
            if count > 1:
                for c in str(count):
                    chars[walker+1] = c
                    walker += 1
            
            runner += 1
            walker += 1
        
        return walker # 결국 walker가 있는 곳이 정답 리스트의 사이즈