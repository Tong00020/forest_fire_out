Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  resources :movies
  root :to => redirect('/movies')

  resources :movies do
    match "similar" => "movies#similar"
  end
end
