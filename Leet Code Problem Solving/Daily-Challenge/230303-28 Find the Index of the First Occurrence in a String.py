class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        h_idx = 0
        isMatched = False

        for h_idx in range(0, len(haystack)):
            if len(haystack)-h_idx < len(needle):
                return -1

            if haystack[h_idx] == needle[0]:
                idx = h_idx
                isMatched = True
                for n in needle:
                    if haystack[idx] != n:
                        isMatched = False
                        break
                    idx+=1

                if isMatched:
                    return h_idx
        
        return -1