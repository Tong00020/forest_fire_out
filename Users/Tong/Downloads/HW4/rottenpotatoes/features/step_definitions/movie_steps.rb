Given /the following movies exist/ do |movies_table|
    movies_table.hashes.each do |movie|
      Movie.create!(movie)
    end
end

Then /I should see "(.*)" before "(.*)"/ do |e1, e2|
    page.body.index(e1).should < page.body.index(e2)
  end