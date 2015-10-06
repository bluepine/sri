# SriRouter

This is a universal router , works on both platform web and ios.

##### Defining Pages
  Eventhough  router gives feel like switching between different pages but at the core they are just react components mounting and unmounting, a component can be Static(which doesn't take any props from parent)/Dynamic(which takes props from parent), we'll use same idea to define our pages 
  
```scala
object HomePage extends StaticPage
object AboutPage extends StaticPage
object UserDetailsPage extends DynamicPage[User]
```

##### Defining Routes
Now lets define routes/configs for pages that defined above, use  `MobileRouterConfig` trait for this.

```scala
object config extends SriRouterConfig {
    override val initialRoute = defineInitialRoute(HomePage, "Home", HomeComponent())

    staticRoute(AboutPage, "About", AboutComponent())

    dynamicRoute(UserDetailsPage, (u: User) => UserDetailsCOmponent(u))

    override val notFound: (StaticPage, NavigatorRoute) = initialRoute

    override def renderScene(route: NavigatorRoute): ReactElement = {
      View(style = MobileStyleSheet.wholeContainer)(
        DefaultNavigationBar(route),
        super.renderScene(route)
      )
    }
}
```

please check source code of [SriRouterConfig](universal/src/main/scala/sri/universal/router/SriRouterConfig.scala) for documentation of methods.

## Examples 
[RouterExampleApp.scala](https://github.com/chandu0101/sri/blob/master/mobile-examples/src/main/scala/sri/mobile/examples/router/RouterExampleApp.scala)

[MoviesApp.scala](https://github.com/chandu0101/sri/blob/master/mobile-examples/src/main/scala/sri/mobile/examples/movies/MoviesApp.scala)

[UIExplorerApp.scala](https://github.com/chandu0101/sri/blob/master/mobile-examples/src/main/scala/sri/mobile/examples/uiexplorer/UIExplorerApp.scala)
