
10.times do |j|
  puts j
  str = ""
  10.times do |n|

    a = []

    (j+1).times do
      a << "#{rand(11) + 1}"
    end

    str += a.join ","
    str += "\n"

  end

  system "echo \"#{str}\" > in#{j}.in"
  t = Thread.new { system "java App < in#{j}.in > out/#{j}.out" }

  sleep 15

  t.kill

  system "killall java"

end
