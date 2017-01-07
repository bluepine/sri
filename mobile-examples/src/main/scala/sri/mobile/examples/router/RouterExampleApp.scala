package sri.mobile.examples.router

import sri.core.ReactElement
import sri.mobile.examples.router.components._
import sri.mobile.examples.router.routes.ThirdModule
import sri.universal.components.DefaultNavigationBar.Style
import sri.universal.components.{DefaultNavigationBar, View}
import sri.universal.router._
import sri.universal.styles.UniversalStyleSheet


object RouterExampleApp {

  object Home extends StaticPage

  object Second extends StaticPage

  object Fourth extends DynamicPage[Person]

  val sampleRightButton = () => RightButton()

  object Config extends UniversalRouterConfig {

    override val initialRoute = defineInitialRoute(Home, "Home", HomeScreen())

    staticRoute(Second, "Second", SecondScreen(), rightButton = sampleRightButton)

    dynamicRoute(Fourth, (p: Person) => FourthScreen(p), rightButton = sampleRightButton)

    moduleRoutes(ThirdModule)

    override val onWillFocus: Function[NavigatorRoute, _] = (route: NavigatorRoute) => {
      println(s"will focus ${route.title}")
    }

    override val onDidFocus: Function[NavigatorRoute, _] = (route: NavigatorRoute) => {
      println(s"did focus ${route.title}")
    }

    override val notFound = UniversalRouteNotFound(initialRoute._1)

    override def renderScene(route: NavigatorRoute,ctrl: UniversalRouterCtrl): ReactElement = {
      View(style = UniversalStyleSheet.wholeContainer)(
        DefaultNavigationBar(CustomNavigationBarTheme),
        super.renderScene(route,ctrl)
      )
    }
  }


  val router = UniversalRouter(Config, style = styles.rootStyle)

}


object styles extends UniversalStyleSheet {

  val rootStyle = style(backgroundColor := "#343536")


}

object CustomNavigationBarTheme extends Style {

  override val navBar = styleE(super.navBar)(backgroundColor := "#343536", borderBottomColor := "#ED4721")

  override val navBarTitleText = styleE(super.navBarTitleText)(color := "orange")

  override val navBarLeftButton = super.navBarLeftButton

  override val navBarButtonText = styleE(super.navBarButtonText)(color := "white")

}