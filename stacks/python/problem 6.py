class MyStack:

    def __init__(self):
        self.l = collections.deque()

    def push(self, x: int) -> None:
        self.l.append(x)
        for i in range(len(self.l) - 1):
            self.l.append(self.l.popleft())

    def pop(self) -> int:
        return self.l.popleft()

    def top(self) -> int:
        return self.l[0]

    def empty(self) -> bool:
        return not self.l
