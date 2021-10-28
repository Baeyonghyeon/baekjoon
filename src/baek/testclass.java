def get_longest_repeat_time(string):
        answer,cnt=1,1

        for i in range(1,len(string)):
            if string[i]==string[i-1]:
                cnt+=1
                if cnt>answer:
                    answer=cnt
            else:
                cnt=1
        return answer



        if __name__=="__main__":
            for _ in range(3):
            string=input()
            print(get_longest_repeat_time(string))
