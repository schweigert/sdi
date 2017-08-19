f = File.new "arquivo.txt", "w"

puts "Quantos bytes?"
bts = gets.to_i

bts = "a"*bts

f.puts bts

f.close
