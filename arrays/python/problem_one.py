def find_largest_element(arr):
    if arr is None or len(arr) == 0:
        raise ValueError("Array must not be null or empty")
    
    max = arr[0]
    for i in range(1, len(arr)):
        if arr[i] > max:
            max = arr[i]
    return max


arr = [10, 20, 4, 45, 99, 6]
largest = find_largest_element(arr)