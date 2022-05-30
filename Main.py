class process:
    def __init__(self,name,arriveTime,serveTime) -> None:
        self.name = name
        self.arriveTime=arriveTime
        self.serveTime = serveTime
        self.waitTime=0
    def toString():
        self.info = "进程名:P"+self.name
        return self.info
    
class processMenu:
    def __init__(self) -> None:
        self.pro=[]
        p1 = process("A",0,5)
        p2 = process("B",1,5)
        p3 = process("C",2,2)
        p4 = process("D",5,1)
        self.pro.append(p1)
        self.pro.append(p2)
        self.pro.append(p3)
        self.pro.append(p4)
    class ProcessQueue:
        def __init__(self) -> None:
            self.k = 0
            self.nowTime = 0
            self.i=0
            def EnqueueLast():
                while self.k<self.pro.size():
                    if self.pro