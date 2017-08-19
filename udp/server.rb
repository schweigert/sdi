require 'socket'

u1 = UDPSocket.new

u1.bind "localhost", 3030

loop {

	a = u1.gets
	puts a.size

}
