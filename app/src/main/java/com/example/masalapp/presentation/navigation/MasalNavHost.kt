package com.example.masalapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.masalapp.di.AppContainer
import com.example.masalapp.presentation.stories.StoryListRoute
import com.example.masalapp.presentation.storydetail.StoryDetailRoute

object MasalDestinations {
    const val STORY_LIST = "stories"
    const val STORY_DETAIL = "stories/{storyId}"

    fun storyDetail(storyId: String) = "stories/$storyId"
}

@Composable
fun MasalNavHost(
    container: AppContainer,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MasalDestinations.STORY_LIST
    ) {
        composable(MasalDestinations.STORY_LIST) {
            StoryListRoute(
                container = container,
                onStoryClick = { storyId ->
                    navController.navigate(MasalDestinations.storyDetail(storyId))
                }
            )
        }
        composable(
            route = MasalDestinations.STORY_DETAIL,
            arguments = listOf(navArgument("storyId") { type = NavType.StringType })
        ) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId").orEmpty()
            StoryDetailRoute(
                storyId = storyId,
                container = container,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
