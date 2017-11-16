system "make"
system "make clear_test"
10.times do |j|
  puts j
  str = ""
  10.times do |n|

    a = []

    6.times do
      a << "#{rand(10) + 1}"
    end

    str += a.join ","
    str += "\n"

  end

  system "echo '#{str}' > in"
  system "make run_without_compile"
end
