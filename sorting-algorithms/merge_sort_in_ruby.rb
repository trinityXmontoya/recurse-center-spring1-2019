def dat_merge_sort(arr)
	# if an array has 1 element or less, it's already sorted
	return arr if arr.size < 2

	# evenly split the array
	mid_index = arr.size / 2
	left_arr = arr[0...mid_index]
	right_arr = arr[mid_index...arr.size]

	merge_two_sorted_arrs_into_one_sorted_arr(
		dat_merge_sort(left_arr), # again
		dat_merge_sort(right_arr) # and again
	)
end

def merge_two_sorted_arrs_into_one_sorted_arr(arr1, arr2)
	final_arr = []
	until arr1.empty? && arr2.empty?
    if arr1.empty?
      final_arr << arr2.shift
    elsif arr2.empty?
      final_arr << arr1.shift
    elsif arr1[0] < arr2[0]
      final_arr << arr1.shift
    else
      final_arr << arr2.shift
    end
  end
  final_arr
end

# sample arr
ARR_SIZE = 1000
arr = ARR_SIZE.times.map { rand(10000) }

# does it work?
puts "dat merge sort worked? #{dat_merge_sort(arr) == arr.sort}"

# how long does it take?
beginning_time = Time.now
dat_merge_sort(arr)
end_time = Time.now
puts "Time elapsed for array of size #{ARR_SIZE} - #{(end_time - beginning_time)*1000} milliseconds"