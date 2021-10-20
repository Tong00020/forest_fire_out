Then /^the director of "([^"]*)" should be "([^"]*)"$/ do |arg1, arg2|
    assert page.body =~ /#{arg1}.+Director.+#{arg2}/m
end