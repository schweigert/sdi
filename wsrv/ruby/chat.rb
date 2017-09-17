#!/usr/bin/ruby -w

require 'savon'

wsdl_url = 'http://localhost:9876/hw?wsdl'
client = Savon.client(wsdl: wsdl_url)

print("Username: ")
username = gets.to_s.chomp

loop do
  print("#{username}: ")
  txt = gets.to_s.chomp
  client.call(:put_msg, message:{txt: txt, user: username})
  response = client.call(:get_msg)
  for i in response.body[:get_msg_response][:return][:item]
    puts i.to_s if i != nil or i != ""
  end
end

10.times do

end
