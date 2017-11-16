require_relative "test_config"

r = Random.new(TestConfig::RANDOM_SEED)

system "make"
system "make clear_test"
TestConfig::TESTS.times do |j|
  puts j
  str = ""
  TestConfig::LINES.times do |n|

    a = []

    TestConfig::NUMBERS_PER_LINE.times do
      a << "#{r.rand(10) + 1}"
    end

    str += a.join ","
    str += "\n"

  end

  system "echo '#{str}' > in"
  system "make run_without_compile"
end
