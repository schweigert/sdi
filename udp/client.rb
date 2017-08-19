require 'socket'

c = UDPSocket.new
c.connect "localhost", 3030

f = File.new "arquivo.txt"
text = f.read
c.puts text
