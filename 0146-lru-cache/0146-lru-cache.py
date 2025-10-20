class LRUCache:
    def __init__(self, capacity: int):
        self.current_action_number = 0
        self.capacity = capacity
        self.cache = {} # key -> [last_used, value]
       
    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.current_action_number += 1
        self.cache[key][1] = self.current_action_number
        return self.cache[key][0]

    def put(self, key: int, value: int) -> None:
        self.current_action_number += 1
        if key in self.cache:
            self.cache[key][0] = value
            self.cache[key][1] = self.current_action_number 
            return
            
        if len(self.cache) == self.capacity:
            min_key, min_value = None, float('inf')
            for k, v in self.cache.items():
                if v[1] < min_value:
                    min_value = v[1]
                    min_key = k
            self.cache.pop(min_key)
        self.cache[key] = [value, self.current_action_number]  