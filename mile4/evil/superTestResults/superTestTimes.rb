#Find times plz
matchPlz = /^(\d+\.\d\d)user (\d+\.\d\d)system \d:\d\d\.\d\delapsed.*$/
benchName = /^benchmarks\/....\/(\w*)\/_script_ass\.s$/

totals = Hash.new(0)
count = 0

ARGV.each{|fileName|
   count = count + 1
   inFile = File.open(fileName, "r")
   tempName = ""

   inFile.each{|line|
      line.chomp!

      if line.match benchName
         #puts line.sub(benchName, '\1')
         tempName = line.sub(benchName, '\1')
      end

      if line.match matchPlz
         #puts line.sub(matchPlz, '\1').to_f
         time = line.sub(matchPlz, '\1').to_f

         #puts "1: #{totals[tempName]}"

         totals[tempName] = totals[tempName] + time
         #puts "2: #{totals[tempName]}"
      end
   }
}

#puts totals

totals.each{|key, value|
   totals[key] = value / count
   puts "#{key} -> #{totals[key]}"
}

#puts totals
